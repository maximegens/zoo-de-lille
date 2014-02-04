package com.platine.zoodelille.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.platine.zoodelille.R;
import com.platine.zoodelille.utils.Constantes;

public class ContactFragment extends Fragment {
	
	EditText message;
	EditText objet;
	Button envoyer;
	ImageView tel;;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

		View myInflatedView = inflater.inflate(R.layout.fragment_contact, container, false);
		
		objet = (EditText)myInflatedView.findViewById(R.id.objet_mail);
		message = (EditText)myInflatedView.findViewById(R.id.contenu_message);
		envoyer = (Button)myInflatedView.findViewById(R.id.button_envoyer_mail);
		tel = (ImageView)myInflatedView.findViewById(R.id.imagetel);
		
		envoyer.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
				emailIntent.setType("message/rfc822");
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{Constantes.ADRESSE_MAIL});
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, objet.getText().toString());
				emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message.getText().toString());
				startActivity(Intent.createChooser(emailIntent, "Envoyer l'email avec : "));
				
			}
		});
		
		tel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final Intent telIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + Constantes.NUMERO_TEL_ZOO));
				startActivity(telIntent);
			}
		});
		

		return myInflatedView;
	}
}
