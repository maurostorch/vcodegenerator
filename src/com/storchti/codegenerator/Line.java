package com.storchti.codegenerator;

import java.util.ArrayList;
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
public class Line {
	ArrayList<String> columns = new ArrayList<String>();

	public ArrayList<String> getColumns() {
		return columns;
	}
	
	public String getColumn(int index) {
		return columns.get(index);
	}

	public void setColumn(String column) {
		this.columns.add(column);
	}
	
	public int countColumns(){
		return columns.size();
	}
	
	public String consomerColumn(){
		if (columns.size() > 0)
			return columns.remove(0);
		return null;
	}
	
}
