package com.liang.tind.leetcode

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File


class MainActivity : AppCompatActivity() {
    private var haveInstallPermission = false

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val info = packageManager.getPackageInfo(packageName, 0)
        version.text = "version:${info.versionName}, versionCode:${info.versionCode}"

        version.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                haveInstallPermission = packageManager.canRequestPackageInstalls()
                if (haveInstallPermission) {
                    install(this)
                } else {
                    startInstallPermissionSettingActivity()
                }
            } else {
                install(this)
            }
        }

    }

    private val REQUEST_CODE = 100

    //  跳转到 设置界面去 开启权限
    private fun startInstallPermissionSettingActivity() {
        //注意这个是8.0新API
        val packageURI = Uri.parse("package:$packageName")
        val intent = Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, packageURI)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.i("tind", "resultCode = $resultCode")
        if (resultCode == Activity.RESULT_OK && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            haveInstallPermission = packageManager.canRequestPackageInstalls()
            if (haveInstallPermission) {
                install(this)
            } else {
                Toast.makeText(this, "需要允许应用内程序安装", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun install(context: Context) {
        val install = Intent(Intent.ACTION_VIEW)
        val apkFile = File(Environment.getExternalStorageDirectory().path + "/tind/app.apk")
        Log.i("tind", "file = ${apkFile.path}")
        Log.i("tind", "exist = ${apkFile.exists()}")

        if (apkFile.exists()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                install.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                val uriForFile = FileProvider.getUriForFile(
                    context,
                    "com.tind.liang.leetcode.provider",
                    apkFile
                )
                install.setDataAndType(uriForFile, "application/vnd.android.package-archive")

            } else {
                install.setDataAndType(
                    Uri.fromFile(apkFile),
                    "application/vnd.android.package-archive"
                )
            }

            install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(install)
        }
    }
}
