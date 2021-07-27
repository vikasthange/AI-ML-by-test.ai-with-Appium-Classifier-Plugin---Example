## This project is the simplest demonstration of using the opensource Machine Learning model plugin "classifier" from test.ai with Appium for apps automation.
# Prerequisite for MacOS:
1. Install Appium (minimum version 1.9)
   1. `npm install -g appium`
2. Install Classifier plugin
   1. `brew install pkg-config cairo pango libpng jpeg giflib`
   2. `npm install -g test-ai-classifier`
3. Android Virtual Device (aka Emulator) or iOS Simulator
   1. Follow Instructions from Android Studio
   2. Set ANDROID_HOME  to SDK and PATH to include adb, android binaries

# Steps to Execute/Run  Test:
1. Start Appium server
   1. `appium`
2. Run script.
   1. `mvn clean test` or run class SearchSettingsTest as test 
   
# Author : Vikas Thange 
Email - vikasthange@gmail.com

Youtube: http://youtube.com/c/vikasthange
