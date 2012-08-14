package com.erlangga.passcode;

import com.erlangga.passcode.model.Menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends FragmentActivity {	
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);               

        if (getSupportFragmentManager().findFragmentById(android.R.id.content) == null) {
        	MainMenuFragment mainMenuFragment = new MainMenuFragment();
            getSupportFragmentManager().beginTransaction().add(android.R.id.content, mainMenuFragment).commit();
        }
    }
	
	private static class MainMenuFragment extends ListFragment{
	    @Override
	    public void onActivityCreated(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Menu.MENU));
	    }
   
	    @Override
	    public void onListItemClick(ListView l, View v, int position, long id) {
	    	switch (position) {
			case 0:
				startActivity(new Intent(getActivity(), SelectPasscodeDropBoxActivity.class));
				break;
			}
	    }
	}
}
