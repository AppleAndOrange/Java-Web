package com.Alisa.Servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidCodeServelet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 60;//设置验证码图片宽度
    private static final int HEIGHT = 20;//设置验证码图片高度
    private static final int LENGTH = 4;//设置验证码长度
    //设置验证码随机出现的字符
    private static final String str = "1234567890" +
            "abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char[] chars = str.toCharArray();//将字符放在数组中方便随机读取
    private static Random random = new Random();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//设置输出的类型为图片
        response.setContentType("image/jpeg");

        //设置不进行缓存
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("expires", "0");

        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_3BYTE_BGR);
        //画笔
        Graphics graphics = image.getGraphics();

        //设置背景颜色并绘制矩形背景
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);

        //用于记录生成的验证码
        String code = null;
      //生成验证码并绘制
        for (int i = 0; i < LENGTH; i++) {
            String c =String.valueOf(chars[random.nextInt(str.length())]).trim();
            graphics.setColor(getColor());
            graphics.drawString(c, 10 * i + 10, 18);
            code += c;
        }
      //生成干扰点
        for (int i = 0; i < 50; i++) {
            graphics.setColor(getColor());
            graphics.drawOval(random.nextInt(60), random.nextInt(20), 1, 1);
        }
      //将生成的验证码存入session中，以便进行校验
        System.out.println("code += c;"+code);
        HttpSession session = request.getSession();
        session.setAttribute("code", code);
        

        //绘制图片
        graphics.dispose();

        //将图片输出到response中
        ImageIO.write(image, "JPEG", response.getOutputStream());
    }

    //随机生成颜色
    private Color getColor() {
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }
	
}
