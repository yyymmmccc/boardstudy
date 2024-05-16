package com.example.boardstudy.util;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Util {

	public static String historyBack() {

		return "<script> history.go(-1); </script> ";
	}
	
	public static String historyBackMsg(String msg) {

		return "<script>alert('" + msg + "'); history.go(-1)</script>";
	}

	public static String replaceMsg(String msg, String uri) {

		return "<script>alert('" + msg + "'); location.href='" + uri + "';</script>";
	}

	public static String replace(String uri) {

		return "<script>location.href='" + uri + "';</script>";
	}

	public static void responseHistoryBack(String msg, HttpServletResponse response) {
		response.setContentType("text/html; charset=UTF-8;");
		try {
			response.getWriter().append(historyBackMsg(msg)); // res에 append를 사용해서 화면을 그릴거
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
