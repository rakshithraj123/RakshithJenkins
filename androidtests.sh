#!/bin/bash

#Start the emulator
D:/android_tool/adt-bundle-windows-x86_64-20140702/sdk/emulator/emulator -avd pixel_api_29 &
EMULATOR_PID=$!

# Wait for Android to finish booting
WAIT_CMD="D:/android_tool/adt-bundle-windows-x86_64-20140702/sdk/platform-tools/adb wait-for-device shell getprop init.svc.bootanim"
until $WAIT_CMD | grep -m 1 stopped; do
  echo "Waiting..."
  sleep 1
done

sleep 30

# Unlock the Lock Screen
D:/android_tool/adt-bundle-windows-x86_64-20140702/sdk/platform-tools/adb shell input keyevent 82

# Clear and capture logcat
D:/android_tool/adt-bundle-windows-x86_64-20140702/sdk/platform-tools/adb logcat -c
D:/android_tool/adt-bundle-windows-x86_64-20140702/sdk/platform-tools/adb logcat > build/logcat.log &
LOGCAT_PID=$!

# Run the tests
./gradlew connectedAndroidTest -i

# Stop the background processes
kill $LOGCAT_PID
kill $EMULATOR_PID