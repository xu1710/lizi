package com.xujingrong.luckytest;
import java.util.*;
import android.app.*;

public class Acollector
{
	public static List<Activity> as=new ArrayList<>();
	public static void adda(Activity a){
		as.add(a);
	}
	public static void removea(Activity a){
		as.remove(a);
	}
	public static void finishall(){
		for(Activity a:as){
			if(!a.isFinishing()){
				a.finish();
			}
		}
	}
}
