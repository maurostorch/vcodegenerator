package com.storchti.codegenerator;

import java.io.Writer;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.resource.loader.StringResourceLoader;
import org.apache.velocity.runtime.resource.util.StringResourceRepositoryImpl;
/*
 * Copyright [2008] [Mauro Storch]
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
public abstract class CodeGenerator {

	private UtilGenerator util;
	private Document doc;
	private StringResourceRepositoryImpl template;
	private Template codeOutput;
	
	private void init() throws Exception{
		this.util = new UtilGenerator();
		doc = new Document();
		Properties p = new Properties();
        p.setProperty( "resource.loader", "template" );
        p.setProperty( "template.resource.loader.description", "Velocity StringResource loader" );
        p.setProperty( "template.resource.loader.class", "org.apache.velocity.runtime.resource.loader.StringResourceLoader" );
        p.setProperty( "template.resource.loader.repository.class", "org.apache.velocity.runtime.resource.util.StringResourceRepositoryImpl" );
		Velocity.init(p);
	}
	
	public void loadTemplate() throws ResourceNotFoundException, ParseErrorException, Exception{
		template = (StringResourceRepositoryImpl)StringResourceLoader.getRepository();
		template.putStringResource("templateDef", getTemplate());
		codeOutput = Velocity.getTemplate("templateDef");
	}
	
	public void generate() throws Exception{
		init();
		loadTemplate();
		loadData();
		VelocityContext context = new VelocityContext();
		context.put("document", this.doc);
		context.put("util", this.util);
			
		this.codeOutput.merge(context, getOutPut());
	}
	
	private void loadData(){
		for(ArrayList<String> v:getInPut()){
			Line l = new Line();
			for(String s:v){
				l.setColumn(s);
			}
			this.doc.setLine(l);
		}
	}

	public abstract ArrayList<ArrayList<String>> getInPut();
	
	public abstract Writer getOutPut();
	
	public abstract String getTemplate();
	
}
