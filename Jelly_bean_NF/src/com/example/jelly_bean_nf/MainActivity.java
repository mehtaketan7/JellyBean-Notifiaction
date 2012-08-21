package com.example.jelly_bean_nf;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Bitmap bm = Bitmap
				.createScaledBitmap(
						BitmapFactory.decodeResource(getResources(),
								R.drawable.avatar),
						getResources().getDimensionPixelSize(
								android.R.dimen.notification_large_icon_width),
						getResources().getDimensionPixelSize(
								android.R.dimen.notification_large_icon_height),
						true);
		Intent intent = new Intent(this, MainActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 01,
				intent, Intent.FLAG_ACTIVITY_CLEAR_TASK);
		Notification.Builder builder = new Notification.Builder(
				getApplicationContext());
		builder.setContentTitle("This is the title");
		builder.setContentText("This is the text");
		builder.setSubText("Some sub text");
		builder.setNumber(101);
		builder.setContentIntent(pendingIntent);
		builder.setTicker("Fancy Notification");
		builder.setSmallIcon(R.drawable.ic_launcher);
		builder.setLargeIcon(bm);
		builder.setAutoCancel(true);
		builder.setPriority(0);
		Notification notification = builder.build();
		NotificationManager notificationManger = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		notificationManger.notify(01, notification);
	}

}