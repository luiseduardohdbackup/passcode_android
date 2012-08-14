package com.erlangga.passcode;

import android.os.Bundle;

/**
 * @author Erlangga
 *
 */

public class AuthenticationActivity extends BasePassCodeActivity {		
    @Override
    protected void onCreate(Bundle bundle) {
    	setFlag(1);
        super.onCreate(bundle);       
    }
}
