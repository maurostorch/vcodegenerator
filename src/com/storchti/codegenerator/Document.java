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
public class Document {
	ArrayList<Line> lines = new ArrayList<Line>();
	
	public void setLine(Line line){
		lines.add(line);
	}
	
	public ArrayList<Line> getLines(){
		return lines;
	}
	
	public Line getLine(int index){
		if(index < lines.size() && lines.size() > 0)
			return lines.get(index);
		return null;
	}
	
	public int countLines(){
		return lines.size();
	}
	
	public Line consumerLine(){
		if(lines.size() > 0)
			return lines.remove(0);
		return null;
	}
	
}
