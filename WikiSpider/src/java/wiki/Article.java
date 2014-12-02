/*
 * Copyright (C) 2014 Xan Mead
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package wiki;

import adt.linked_list.LinkedList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * 
 * @author Xan Mead
 */
public class Article {
	
	/** Name of the article. */
	private String name;
	
	/** Root node of the article's main content. */
	private Element body;
	
	/** Nodes that constitute the body of the Wikipedia article. */
	private LinkedList<String> content;
	
	/** Categories in which this article is included. */
	private LinkedList<String> categories;
	
	/** Other articles referenced within the article. */
	private LinkedList<String> links;
	
	/** Tells whether the article's content has been parsed. */
	private boolean contentReady;
	
	public Article(Document page) {
		
	}
}
