package com.example.hmh.firedemo.utils;

import android.view.MotionEvent;

public class Utils {
	
	/**
	 * ��ȡ�����¼���Action����
	 * @param ev
	 */
	public static String getActionName(MotionEvent ev) {
		String action;
		switch (ev.getAction()) {
		case MotionEvent.ACTION_CANCEL:
			action = "CANCEL";
			break;
		case MotionEvent.ACTION_DOWN:
			action = "DOWN";
			break;
		case MotionEvent.ACTION_MOVE:
			action = "MOVE";
			break;
		case MotionEvent.ACTION_UP:
			action = "UP";
			break;
		default:
			action = "UNKNOWN_ACTION";
			break;
		}
		if (action.length() < 5) {
			for (int i = action.length(); i < 5; i++) {
				action += " ";
			}
		}
		return action;
	}
}
