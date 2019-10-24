/*
 * Copyright (C) 2019 Toshiba Corporation
 * SPDX-License-Identifier: Apache-2.0
 */

package org.wcardinal.controller.data.internal;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;

public class SMapPatchesPackedImplDeserializer extends JsonDeserializer<SPatchesPacked<?, ?>> implements ContextualDeserializer {
	final JavaType valueType;

	public SMapPatchesPackedImplDeserializer(){
		this.valueType = null;
	}

	public SMapPatchesPackedImplDeserializer( final JavaType valueType ) {
		this.valueType = valueType;
	}

	@Override
	public JsonDeserializer<?> createContextual( final DeserializationContext ctxt, final BeanProperty property) throws JsonMappingException {
		final JavaType javaType = (property == null ? ctxt.getContextualType() : property.getType());
		final JavaType valueType = javaType.containedType( 0 );
		final SMapPatchesPackedImplDeserializer deserializer = new SMapPatchesPackedImplDeserializer( valueType );
		return deserializer;
	}

	@Override
	public SPatchesPacked<?, ?> deserialize( final JsonParser parser, final DeserializationContext ctxt ) throws IOException, JsonProcessingException {
		return SMapPatchesPackedImpl.deserialize( parser, ctxt, valueType );
	}
}
