/*
 * Copyright (C) 2019 Toshiba Corporation
 * SPDX-License-Identifier: Apache-2.0
 */

package manual.history;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
@SuppressWarnings( "deprecation" )
public class I18nConfig extends org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter {
	@Bean
	public MessageSource messageSource() {
		final ReloadableResourceBundleMessageSource result = new ReloadableResourceBundleMessageSource();
		result.setBasenames("classpath:/manual/history/i18n/messages");
		result.setDefaultEncoding("UTF-8");
		result.setCacheSeconds(-1);
		return result;
	}
}
