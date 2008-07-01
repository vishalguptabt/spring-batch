/*
 * Copyright 2002-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.batch.core.step;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.batch.item.NoWorkFoundException;
import org.springframework.batch.repeat.ExitStatus;

/**
 * Fails the step if no items have been processed ( item count is 0).
 * 
 * @author Robert Kasanicky
 */
public class NoWorkFoundListener extends StepExecutionListenerSupport {

	public ExitStatus afterStep(StepExecution stepExecution) {
		if (stepExecution.getItemCount().intValue() == 0) {
			throw new NoWorkFoundException("Step has not processed any items");
		}
		return stepExecution.getExitStatus();
	}

}