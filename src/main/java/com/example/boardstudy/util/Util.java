package com.example.boardstudy.util;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Util {
	
	public static String historyBack(String msg) {

		return String.format("""
						<script>
							const msg = '%s'.trim();
							if(msg.length > 0){
								alert(msg);
							}
							history.back();
						</script>
					""", msg);
	}
	
	public static String replace(String msg, String uri) {

		return String.format("""
						<script>
							const msg = '%s'.trim();
							if(msg.length > 0){
								alert(msg);
							}
							location.replace('%s');
						</script>
					""", msg, uri);
	}

	public static void responseHistoryBack(String msg, HttpServletResponse response) {
		response.setContentType("text/html; charset=UTF-8;");
		try {
			response.getWriter().append(historyBack(msg)); // res에 append를 사용해서 화면을 그릴거
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
