package com.erlangga.passcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.erlangga.passcode.model.MenuSelectPasscode1;

/**
 * @author Erlangga
 *
 */

public class SelectPasscodeDropBoxActivity extends FragmentActivity{
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);               

        if (getSupportFragmentManager().findFragmentById(android.R.id.content) == null) {
        	SelectMenuPasscode1 selectMenu = new SelectMenuPasscode1();        	
            getSupportFragmentManager().beginTransaction().add(android.R.id.content, selectMenu).commit();
        }
    }
	
	private static class SelectMenuPasscode1 extends ListFragment{
		@Override
		public void onActivityCreated(Bundle bundle) {
			super.onCreate(bundle);
	        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, MenuSelectPasscode1.MENU));
		}
		
	    @Override
	    public void onListItemClick(ListView l, View v, int position, long id) {
	    	switch (position) {
			case 0:
				startActivity(new Intent(getActivity(), AuthenticationActivity.class));
				break;
			case 1:
				startActivity(new Intent(getActivity(), CreatePasscodeActivity.class));
				break;
			}
	    }
	}
}
