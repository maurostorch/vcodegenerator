package com.storchti.codegenerator.gui;

import java.awt.Component;

import org.mvc.structure.DefaultModel;
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
public abstract class CodeGenGuiModel implements DefaultModel<Object>{
	
	public abstract Component getParent();
	
	public abstract void setTemplateText(String template);
	
	public abstract String getTemplateText();
	
	public abstract void setDataText(String data);
	
	public abstract String getDataText();
	
	public abstract void setCodeText(String code);
	
	public abstract String getCodeText();
	
	public abstract void setDataFileName(String filename);
	
	public abstract String getDataFileName();
	
	public abstract void setTemplateFileName(String filename);
	
	public abstract String getTemplateFileName();
	
	public void fromObject(Object values) {
		Object[] tempValues = (Object[]) values;
		setTemplateText((String) tempValues[0]);
		setDataText((String) tempValues[1]);
		setCodeText((String) tempValues[2]);
		setDataFileName((String) tempValues[3]);
		setTemplateFileName((String) tempValues[4]);
	}

	public Object toObject() {
		Object[] values = new Object[5];
		values[0] = getTemplateText();
		values[1] = getDataText();
		values[2] = getCodeText();
		values[3] = getDataFileName();
		values[4] = getTemplateFileName();
		return values;
	}

}
