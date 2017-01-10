package com.pravat.jencryptgui;

import com.pravat.jencrypt.*;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

@Deprecated
public class mainController implements javafx.fxml.Initializable, EventHandler<ActionEvent> {

	@FXML
	private Text waterMark;
	@FXML
	private TextField enterPassword;
	@FXML
	private TextField decryptPassword;
	@FXML
	private TextField saltText;
	@FXML
	private TextArea showResults;
	@FXML
	private Button encryptBTN;
	@FXML
	private Button decryptBTN;

	public void initialize(URL location, ResourceBundle resources) {
		encryptBTN.setOnAction(this);
		decryptBTN.setOnAction(this);
	} 

	public void handle(ActionEvent E) {
		JEncrypt encryptSource = new JEncrypt();
		if(E.getSource() == encryptBTN)
		{
			String password = enterPassword.getText();
			String saltedPass = saltText.getText();
			if(password.isEmpty())
			{
				showResults.setText("Please input something into the encrypt textfield.");
				return;
			}
			try {
				showResults.setText(
						"MD5 Hash: " + encryptSource.encryptMD5(password) + "\n" +
						"Base64 Hash: " + encryptSource.encryptBase64(password) + "\n" +
						"SHA1 Hash: " + encryptSource.encryptSHA1(password) + "\n" +
						"SHA256 Hash: " + encryptSource.encryptSHA256(password) + "\n" +
						"SHA384 Hash: " + encryptSource.encryptSHA384(password) + "\n" +
						"SHA512 Hash: " + encryptSource.encryptSHA512(password, saltedPass) + "\n");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				showResults.setText("Error - Could not encrypt.");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				showResults.setText("Error - Salted password is unsupported.");
			}
		} else if (E.getSource() == decryptBTN)
		{
			String base64 = decryptPassword.getText();
			if(base64.isEmpty())
			{
				showResults.setText("Please input something into the decrypt textfield.");
				return;
			}
			showResults.setText("Base 64 Decryption: " + encryptSource.decryptBase64(base64));
		}
	}

} // end class
