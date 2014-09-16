package com.example.wechatstudy;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;

public class PlusActionProvider extends ActionProvider{
	
	private Context context;

	public PlusActionProvider(Context context) {
		super(context);
		this.context = context;
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateActionView() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void onPrepareSubMenu(SubMenu subMenu){
		subMenu.clear();
		subMenu.add(context.getString(R.string.plus_group_chat))
				.setIcon(R.drawable.ofm_group_chat_icon)
				.setOnMenuItemClickListener(new OnMenuItemClickListener(){

					@Override
					public boolean onMenuItemClick(MenuItem item) {
						// TODO Auto-generated method stub
						return true;
					}
					
				});
		subMenu.add(context.getString(R.string.plus_add_friend))  
        		.setIcon(R.drawable.ofm_add_icon)  
        		.setOnMenuItemClickListener(new OnMenuItemClickListener() {  
		            @Override  
		            public boolean onMenuItemClick(MenuItem item) {  
		                return false;  
		            }  
        });  
		subMenu.add(context.getString(R.string.plus_video_chat))  
		        .setIcon(R.drawable.ofm_video_icon)  
		        .setOnMenuItemClickListener(new OnMenuItemClickListener() {  
		            @Override  
		            public boolean onMenuItemClick(MenuItem item) {  
		                return false;  
		            }  
		        });  
		subMenu.add(context.getString(R.string.plus_scan))  
		        .setIcon(R.drawable.ofm_qrcode_icon)  
		        .setOnMenuItemClickListener(new OnMenuItemClickListener() {  
		            @Override  
		            public boolean onMenuItemClick(MenuItem item) {  
		                return false;  
		            }  
		        });  
		subMenu.add(context.getString(R.string.plus_take_photo))  
		        .setIcon(R.drawable.ofm_camera_icon)  
		        .setOnMenuItemClickListener(new OnMenuItemClickListener() {  
		            @Override  
		            public boolean onMenuItemClick(MenuItem item) {  
		                return false;  
		            }  
		        });
	}
	
	public boolean hasSubMenu(){
		return true;
	}

}
