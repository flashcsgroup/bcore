/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * 
 */
package uz.sunet.bcore.cqrs.command.impl;

import org.springframework.stereotype.Component;
import uz.sunet.bcore.cqrs.command.handler.CommandHandler;

import javax.inject.Inject;

/**
 * @author Slawek
 */
@Component
public class RunEnvironment {

	public interface HandlersProvider{
		CommandHandler<Object, Object> getHandler(Object command);
	}
	
	@Inject
	private HandlersProvider handlersProfiver;
	
	public Object run(Object command) {		
		CommandHandler<Object, Object> handler = handlersProfiver.getHandler(command);
		
		//You can add Your own capabilities here: dependency injection, security, transaction management, logging, profiling, spying, storing commands, etc
		
		Object result = handler.handle(command);

		//You can add Your own capabilities here
		
		return result;
	}

}
