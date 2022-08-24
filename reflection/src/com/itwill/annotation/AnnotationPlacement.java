package com.itwill.annotation;
@MakerAnnotation
	public class AnnotationPlacement {
	
	    @MakerAnnotation
	    String field;
	
	    @MakerAnnotation
	    public void method1(@MakerAnnotation String str) {
	        @MakerAnnotation
	        String test;
	    }
	}		