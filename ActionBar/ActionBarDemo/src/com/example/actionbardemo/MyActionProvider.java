package com.example.actionbardemo;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;

public class MyActionProvider extends ActionProvider{
	
	public MyActionProvider(Context context){
		super(context);
	}

	@Override
	public View onCreateActionView() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override  
    public void onPrepareSubMenu(SubMenu subMenu) {  
        subMenu.clear();  
        subMenu.add("sub item 1").setIcon(R.drawable.ic_launcher)  
                .setOnMenuItemClickListener(new OnMenuItemClickListener() {  
                    @Override  
                    public boolean onMenuItemClick(MenuItem item) {  
                        return true;  
                    }  
                });  
        subMenu.add("sub item 2").setIcon(R.drawable.ic_launcher)  
                .setOnMenuItemClickListener(new OnMenuItemClickListener() {  
                    @Override  
                    public boolean onMenuItemClick(MenuItem item) {  
                        return false;  
                    }  
                });  
    }  
  
    @Override  
    public boolean hasSubMenu() {  
        return true;  
    } 
}
