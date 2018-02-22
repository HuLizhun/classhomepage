package com.textile083.entity;

public class Article {
	private int id;// 主键
	private String number;// 学生学号
	private String name;// 学生姓名
	private String title;// 文章标题
	private String content;// 文章内容

	public Article() {
	}

	public Article(int id, String number, String name, String title, String content) {
		this.id = id;
		this.number = number;
		this.name = name;
		this.title = title;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
