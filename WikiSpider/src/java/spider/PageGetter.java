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

package spider;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * Class used for retrieving HTML pages.
 * @author Xan Mead
 */
public class PageGetter {
	
	/**
	 * Precondition: URL is valid.
	 * @param url URL of the web page to be retrieved.
	 * @return Document object containing the html of the requested page.
	 */
	public static Document doGet(String url) {
		
		Document dom = null;
		
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
		
		int responseCode = 400; // Default to "Bad Request"
		
		try {	
			HttpResponse response = client.execute(request);
			responseCode = response.getStatusLine().getStatusCode();

			if (responseCode == 200) {
				
				// Get InputStream for response
				InputStream is = response.getEntity().getContent();
				
				// Build a document
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = dbf.newDocumentBuilder();
				
				// Parse the InputStream
				dom = builder.parse(is);
			}
			else {
				System.out.println("Response not OK!");
				System.out.println("Response code: " + responseCode);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (SAXException | ParserConfigurationException ex) {
			ex.printStackTrace();
		}
		return dom;
	}
}
