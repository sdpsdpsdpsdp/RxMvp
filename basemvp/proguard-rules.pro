# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-basedirectory proguard-pro

-include proguard-normal.pro

-include proguard-self.pro

-include proguard-ARecyclerView.pro

-include proguard-avi-loading.pro

-include proguard-butterknife.pro

-include proguard-canary-debug.pro

-include proguard-canary-release.pro

-include proguard-constraint-layout.pro

-include proguard-design.pro

-include proguard-eventbus-3.pro

-include proguard-eventbus.pro

-include proguard-glide.pro

-include proguard-google-gson.pro

-include proguard-okhttp3-logging-interceptor.pro

-include proguard-okhttp3.pro

-include proguard-picasso.pro

-include proguard-proguard-design.pro

-include proguard-recyclerview-v7.pro

-include proguard-retrofit-adapter-rxjava.pro

-include proguard-retrofit-converter-gson.pro

-include proguard-retrofit.pro

-include proguard-rxandroid.pro

-include proguard-rxjava.pro

-include proguard-rxlifecycle-android.pro

-include proguard-rxlifecycle-components.pro

-include proguard-rxlifecycle.pro

-include proguard-rxpermissions.pro

-include proguard-support-v4.pro

-include proguard-support-v7-appcompat.pro