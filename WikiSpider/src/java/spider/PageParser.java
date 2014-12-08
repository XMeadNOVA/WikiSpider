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

import adt.queue.Queue;
import adt.queue.QueueUnderflowException;
import wiki.Article;

/**
 *
 * @author Xan Mead
 */
public class PageParser {
	private Queue<PageParseJob> jobQueue;
	
	private Queue<Article> finishedArticles;
	
	private int jobsReceived;
	
	private int jobsProcessed;
	
	private int jobsReleased;
	
	public PageParser() {
		jobQueue = new Queue<>();
		finishedArticles = new Queue<>();
		jobsReceived = 0;
		jobsProcessed = 0;
		jobsReleased = 0;
	}
	
	public boolean hasJobs() {
		return !jobQueue.isEmpty();
	}
	
	public boolean hasFinishedArticle() {
		return !finishedArticles.isEmpty();
	}
	
	public void addJob(PageParseJob job) {
		jobQueue.enqueue(job);
		jobsReceived++;
	}
	
	public Article getFinishedArticle() {
		try {
			jobsReleased++;
			return finishedArticles.dequeue();
		} catch (QueueUnderflowException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
