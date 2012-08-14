package com.erlangga.passcode;

import android.os.Bundle;


/**
 * @author Erlangga
 *
 */

public class CreatePasscodeActivity extends BasePassCodeActivity {
	@Override
	protected void onCreate(Bundle bundle) {
		setFlag(2);
		super.onCreate(bundle);	
	}
}
