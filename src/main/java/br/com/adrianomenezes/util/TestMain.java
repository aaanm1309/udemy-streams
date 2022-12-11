package br.com.adrianomenezes.util;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
	private static final List<String> list = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println(LinkUtil.getResponseCode("https://www.google.com"));
		System.out.println(LinkUtil.getResponseCode("http://www.adrianomenezes.com"));
		System.out.println(LinkUtil.getResponseCode("http://www.adrianomenezes.com/123"));
		System.out.println(LinkUtil.getResponseCode("http://www.google.com/trgfsdgdfs"));
		System.out.println(LinkUtil.getResponseCode("https://the-internet.herokuapp.com/broken_images"));



	}

}
