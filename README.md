![Alt text](/rsrc/icon.png)
# Overview
JEncrypt (or Java Encrypt) is a Java-based application that is used to hash your password with grade AAA security.
The code uses Apache commoncode-codec libraries.
Proper documentation is provided below the README.

# Dependencies
JEncrypt utilizes two forms.
- The first form is an editable source code for programmers to code
- The second form is a default GUI to make an easy-to-use interface for the user
	- The default form is the JEncrypt.jar file
	
# Download Setup
- Clone or download this repository as a zip file
- Extract the downloaded zip file
- Find and open the "JGeolocator.jar" file inside the unzipped folder
- Finished!

# Default GUI Overlook
![Alt text](/rsrc/gui.PNG)

# Setup
- Copy and paste the entire JEncrypt's "com" folder into your project's "src" folder
- Copy and paste the entire JEncrypt's "lib" folder in your project's main directory
- Go to your IDE, go to the project's properties in the IDE, go to the Java Build Path, then go to the Libraries and add
  all of the .jar files from the lib folder to your project.

# Documentation
Import the JEncrypt class
```
import com.pravat.jencrypt.JEncrypt;
```
Make a JEncrypt instance
```
JEncrypt encryptionSource = new JEncrypt();
```
Encryption Possiblities
```
String password = "test";
encryptSource.encryptMD5(password)//encrypt password to md5
encryptSource.encryptBase64(password)//encrypt password to base64
encryptSource.encryptSHA1(password)//encrypt password to SHA1
encryptSource.encryptSHA256(password)//encrypt password to SHA256
encryptSource.encryptSHA384(password)//encrypt password to SHA384
encryptSource.encryptSHA512(password, saltedPass)//encrypt password to SHA512
```
Decryption
```
String base64 = "dGVzdA=="
encryptSource.decryptBase64(base64) //decrypt base64 to password (returns "test")
```
