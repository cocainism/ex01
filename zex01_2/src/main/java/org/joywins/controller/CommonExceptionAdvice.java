package org.joywins.controller;
//...233p.
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/*
 * ...233p.Spring MVC�� ����Ҷ� Controller���� Exception�� ó���ϴ� ���.
 * ...1. @ExceptionHandler �̿�.
 * ...2. @ControllerAdvice �̿�.
 * ...		������ Exception ó�� ���� ��ü�� ����ϴ� ���.
 * ...		ȣ��Ǵ� �޼��忡�� �߻��� Exception�� ��� ó��.
 * ...		@ControllerAdviceŬ������ �޼���� �߻��� Exception��ü�� Ÿ�Ը��� �Ķ���ͷ�
 * ...		��밡���ϰ�, �Ϲ�Controlleró�� Mdolel�� �Ķ���ͷ� �������� �����Ƿ�
 * ...		���� ModelAndViewŸ���� ����ϴ� ���·� �ۼ��ؾ� ��.
 * ...		2.1. Ŭ������ @ControllerAdvice ó��.
 * ...		2.2. �� �޼��忡 @ExceptionHandler �̿��ؼ� ������ Ÿ���� Exception ó��.
 * ...		ex) http://localhost:8080/z/zboard/read?bno=36 ������ ���ܸ� �߻����Ѻ�.
 * ...3. @ResponseStatus �̿��� Http���� �ڵ� ó��.
 */
@ControllerAdvice
public class CommonExceptionAdvice {

	  private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);

	  /*
	   * ...233p. common()�޼��带 �̿��ؼ� ExceptionŸ������ ó���Ǵ� ��� ���ܸ� ó��.
	   */
	  //@ExceptionHandler(Exception.class)
	  public String common(Exception e) {

	    logger.info(e.toString());

	    return "/zboard/error_common";
	  }	  
	  
	  /*
	   * ...234p.ModelAndView�� �ϳ��� ��ü�� Model�����Ϳ� Viewó���� ���ÿ� �� �� �ִ� ��ü.
	   * ...������ ������ MVC������ ModelAndViewŸ���� �̿��ؼ� �����͸� ���������,
	   * ...�ֱٿ��� ���� �̷��� ���� �ʰ�, �̹� ���ó�� ������ �Ķ���͸� ����ϴ� ��쿡
	   * ...�ַ� �����.
	   */
	  @ExceptionHandler(Exception.class)
	  private ModelAndView errorModelAndView(Exception ex) {

	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("/zboard/error_common");
	    modelAndView.addObject("exception", ex);

	    return modelAndView;
	  }	  
	
}
