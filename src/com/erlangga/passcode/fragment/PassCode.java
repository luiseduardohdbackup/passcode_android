package com.erlangga.passcode.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.erlangga.passcode.R;

/**
 * @author Erlangga
 *
 */

public class PassCode extends Fragment implements OnClickListener {	
	
	private EditText etPassCode1;
	private EditText etPassCode2;
	private EditText etPassCode3;
	private EditText etPassCode4;
	private Button btn0;
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;
	private Button btn6;
	private Button btn7;
	private Button btn8;
	private Button btn9;
	private Button btnBack;

	private TextView tvTitlePasscode;
	private int flag;
	private int enterPasscodeAgainStep = 0;
	private String tmpPassCode = null;
	
	private static final String PASSCODE = "1234";
	
	public static PassCode newInstance(int flag) {
	    PassCode passCode = new PassCode();	    

	    Bundle bundle = new Bundle();
	    bundle.putInt("flag", flag);
	    passCode.setArguments(bundle);

	    return passCode;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Bundle argBundle = this.getArguments();
	    flag = argBundle.getInt("flag");
		return inflater.inflate(R.layout.passcode, container, false);	
	}

	@Override
	public void onStart() {
		super.onStart();
		initUI();
	}

	private void initUI() {
		final FragmentActivity context = getActivity();
		
		etPassCode1 = (EditText) getActivity().findViewById(R.id.passcode1);
		etPassCode1.addTextChangedListener(new TextWatcher() {
			
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if(s.length()==1){
					etPassCode2.requestFocus();
				}
			}
			
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {				
			}
			
			public void afterTextChanged(Editable s) {				
			}
		});		
		
		etPassCode2 = (EditText) getActivity().findViewById(R.id.passcode2);
		etPassCode2.addTextChangedListener(new TextWatcher() {
			
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if(s.length()==1){
					etPassCode3.requestFocus();
				}
			}
			
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				
			}
			
			public void afterTextChanged(Editable s) {
				
			}
		});
				
		etPassCode3 = (EditText) getActivity().findViewById(R.id.passcode3);
		etPassCode3.addTextChangedListener(new TextWatcher() {
			
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if(s.length()==1){
					etPassCode4.requestFocus();
				}
			}
			
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				
			}
			
			public void afterTextChanged(Editable s) {
				
			}
		});
		
		etPassCode4 = (EditText) getActivity().findViewById(R.id.passcode4);
		etPassCode4.addTextChangedListener(new TextWatcher() {
			
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if(s.length()==1){
					String passCode1 = etPassCode1.getText().toString();
					String passCode2 = etPassCode2.getText().toString();
					String passCode3 = etPassCode3.getText().toString();
					String passCode4 = etPassCode4.getText().toString();
					
					String passCodeFull = passCode1+passCode2+passCode3+passCode4;
					
					switch (flag) {
					case 1:
						if (passCodeFull.equals(PASSCODE)) {
							Toast.makeText(context, "success",
									Toast.LENGTH_LONG).show();
							context.finish();
						} else {
							clear();
							Toast.makeText(context, "Wrong passcode",
									Toast.LENGTH_LONG).show();
						}
						break;
					case 2:						
						switch (enterPasscodeAgainStep) {
						case 0:								
							if(PASSCODE.equals(passCodeFull)){								
								clear();
								tvTitlePasscode.setText("Enter your new passcode");
								enterPasscodeAgainStep = 1;
							}else{
								Toast.makeText(context, "wrong passcode, please try again", Toast.LENGTH_LONG).show();	
								clear();
							}							
							break;
						case 1:
							tmpPassCode = passCodeFull;
							clear();
							tvTitlePasscode.setText("Re-enter your new passcode");
							enterPasscodeAgainStep = 2;
							break;
						case 2:
							if(tmpPassCode.equals(passCodeFull)){								
								Toast.makeText(context, "Your new passcode success to saving", Toast.LENGTH_LONG).show();
								context.finish();		
							}else{
								clear();
								tmpPassCode = null;
								tvTitlePasscode.setText("Enter your passcode");
								enterPasscodeAgainStep =0;
								Toast.makeText(context, "The passcode did not match, please try again", Toast.LENGTH_LONG).show();
							}
							break;
						}						
						break;
					}													
				}
			}
			
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {				
			}
			
			public void afterTextChanged(Editable s) {				
			}
		});
		
		tvTitlePasscode = (TextView) getActivity().findViewById(R.id.passcode_title);
		btn0 = (Button) getActivity().findViewById(R.id.n0);
		btn1 = (Button) getActivity().findViewById(R.id.n1);
		btn2 = (Button) getActivity().findViewById(R.id.n2);
		btn3 = (Button) getActivity().findViewById(R.id.n3);
		btn4 = (Button) getActivity().findViewById(R.id.n4);
		btn5 = (Button) getActivity().findViewById(R.id.n5);
		btn6 = (Button) getActivity().findViewById(R.id.n6);
		btn7 = (Button) getActivity().findViewById(R.id.n7);
		btn8 = (Button) getActivity().findViewById(R.id.n8);
		btn9 = (Button) getActivity().findViewById(R.id.n9);
		btnBack = (Button) getActivity().findViewById(R.id.back);
		
		btn0.setOnClickListener(this);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn6.setOnClickListener(this);
		btn7.setOnClickListener(this);
		btn8.setOnClickListener(this);
		btn9.setOnClickListener(this);
		btnBack.setOnClickListener(this);
		
		etPassCode1.requestFocus();
	}
	
	private void clear(){
		etPassCode1.setText("");
		etPassCode2.setText("");
		etPassCode3.setText("");
		etPassCode4.setText("");
		etPassCode1.requestFocus();
	}
	
	private void onAction(String passText){
		if(etPassCode1.isFocused()){
			etPassCode1.setText(passText);			
		}else if(etPassCode2.isFocused()){
			etPassCode2.setText(passText);
		}else if(etPassCode3.isFocused()){
			etPassCode3.setText(passText);			
		}else if(etPassCode4.isFocused()){
			etPassCode4.setText(passText);
		}
	}
	
	private void onActionBack(){
		if(etPassCode1.isFocused()){
			etPassCode1.setText("");			
		}else if(etPassCode2.isFocused()){
			etPassCode2.setText("");
			etPassCode1.setText("");
			etPassCode1.requestFocus();
		}else if(etPassCode3.isFocused()){
			etPassCode3.setText("");
			etPassCode2.setText("");
			etPassCode2.requestFocus();
		}else if(etPassCode4.isFocused()){
			etPassCode4.setText("");
			etPassCode3.setText("");
			etPassCode3.requestFocus();
		}
	}

	public void onClick(View v) {
		if(v.getId() == R.id.back){
			onActionBack();
		}else{
			String passText = null;		
			switch (v.getId()) {
			case R.id.n0:	
				passText="0";
				break;
			case R.id.n1:
				passText="1";
				break;
			case R.id.n2:	
				passText="2";
				break;
			case R.id.n3:	
				passText="3";
				break;
			case R.id.n4:	
				passText="4";
				break;
			case R.id.n5:	
				passText="5";
				break;
			case R.id.n6:	
				passText="6";
				break;
			case R.id.n7:	
				passText="7";
				break;
			case R.id.n8:	
				passText="8";
				break;
			case R.id.n9:	
				passText="9";
				break;
			}		
			onAction(passText);
		}		
	}
}
