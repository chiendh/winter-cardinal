/*
 * Copyright (C) 2019 Toshiba Corporation
 * SPDX-License-Identifier: Apache-2.0
 */

package basics;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;

import org.wcardinal.controller.ControllerFacade;
import org.wcardinal.controller.annotation.Callable;
import org.wcardinal.controller.annotation.Controller;
import org.wcardinal.controller.annotation.ExceptionHandler;
import org.wcardinal.controller.annotation.OnCreate;
import org.wcardinal.controller.data.SLong;
import org.wcardinal.controller.data.annotation.NonNull;
import org.wcardinal.exception.NullArgumentException;

@Controller
public class BasicsException5Controller {

	final Method taskMethod;

	public BasicsException5Controller(){
		taskMethod = ReflectionUtils.findMethod( this.getClass(), "task" );
	}

	@Callable
	void callable() {
		throw new NullPointerException();
	}

	@OnCreate
	void init() {

	}

	@Autowired
	ControllerFacade facade;

	@Autowired @NonNull
	SLong handle1_result;

	@Autowired @NonNull
	SLong handle2_result;

	@Autowired @NonNull
	SLong handle3_result;

	@ExceptionHandler( "init" )
	void handle1( final NullArgumentException e, final Method method ) {
		handle1_result.incrementAndGet();
	}

	@ExceptionHandler( "callable" )
	void handle2( final Exception e ) {
		handle2_result.incrementAndGet();
	}

	@ExceptionHandler( "callable" )
	void handle3( final Method method ) {
		handle3_result.incrementAndGet();
	}
}
