Hospital Management System Deployment (Offline Use Only)

a.Project Structure
- Clone or download project
- Open in Android Studio
- Folder layout:
   Hospital Management System-Hospital-App/
  ├── app/
  │   ├── src/main/java/hospitalapp/
  │   ├── res/
  │   └── google-services.json (only if Firebase used)
  ├── firebase/
  ├── build.gradle
  └── deployment/deploy_steps.md

b.Android Setup
1. File > Open > Select project folder
2. Wait for Gradle sync
3. (Optional) Build > Clean Project
4. (Optional) Build > Rebuild Project

c.Firebase Setup (Skip if offline)
1. Create Firebase project
2. Add Android app: `com.mediqueue.hospitalapp`
3. Download `google-services.json` → place in `/app/`
4. Enable Realtime Database
5. Set rules from: `firebase/firebase_rules.json`

 Don’t push `google-services.json` to GitHub

d. Run the App
1. Connect device or open emulator
2. Press ▶️ (Shift + F10)
3. App runs locally

e.Generate APK
1. Build > Generate Signed Bundle/APK > APK
2. Create keystore or use existing `.jks`
3. Build APK
4. Install `.apk` manually to device.

