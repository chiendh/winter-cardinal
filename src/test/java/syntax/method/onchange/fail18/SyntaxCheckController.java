/*
 * Copyright (C) 2019 Toshiba Corporation
 * SPDX-License-Identifier: Apache-2.0
 */

package syntax.method.onchange.fail18;

import java.util.SortedMap;

import org.springframework.beans.factory.annotation.Autowired;

import org.wcardinal.controller.annotation.Controller;
import org.wcardinal.controller.annotation.OnChange;
import org.wcardinal.controller.data.SString;

@Controller
public class SyntaxCheckController {
	@Autowired
	SString bar;

	@Autowired
	SyntaxCheckComponent component;

	@OnChange( "component.navigable_map" )
	void onChangeB18( final SortedMap<String, String> added, final SortedMap<String, Object> removed ){}
}
