package com.erlangga.passcode;

import com.erlangga.passcode.fragment.PassCode;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

/**
 * @author Erlangga
 *
 */

public class BasePassCodeActivity extends FragmentActivity {
	
	protected int flag;

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.create_activity);

		Fragment passCode = PassCode.newInstance(flag);
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.add(android.R.id.content, passCode);
		ft.commit();
	}		
}
