package com.onebookshop.model.generators;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

public class CartIdGenerator extends SequenceStyleGenerator{
	
	public static final String VALUE_PREFIX_PARAMETER = "valuePrefix";
	public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
	private String valuePrefix;
	private String numberFormat;
	
	
	@Override
	public void configure(Type type, Properties params, Dialect dialect) throws MappingException {		
		super.configure(LongType.INSTANCE, params, dialect);
		valuePrefix = ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER, params);
		numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, params);
	}
	
	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		return valuePrefix + String.format(numberFormat, super.generate(session, object));
		
	}
}
