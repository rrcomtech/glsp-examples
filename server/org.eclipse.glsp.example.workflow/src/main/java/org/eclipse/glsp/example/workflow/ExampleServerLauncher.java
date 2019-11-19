/********************************************************************************
 * Copyright (c) 2019 EclipseSource and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/
package org.eclipse.glsp.example.workflow;

import org.apache.log4j.BasicConfigurator;
import org.eclipse.elk.alg.layered.options.LayeredMetaDataProvider;
import org.eclipse.glsp.layout.ElkLayoutEngine;
import org.eclipse.glsp.server.launch.DefaultGLSPServerLauncher;
import org.eclipse.glsp.server.launch.GLSPServerLauncher;
import org.eclipse.glsp.server.websocket.WebsocketServerLauncher;

public final class ExampleServerLauncher {
   private ExampleServerLauncher() {}

   public static void main(final String[] args) {
      BasicConfigurator.configure();
      ElkLayoutEngine.initialize(new LayeredMetaDataProvider());
      GLSPServerLauncher launcher;

      if (args.length == 1 && args[0].equals("websocket")) {
         launcher = new WebsocketServerLauncher(new WorkflowGLSPModule(), "/workflow");
         launcher.start("localhost", 8081);

      } else {
         launcher = new DefaultGLSPServerLauncher(new WorkflowGLSPModule());
         launcher.start("localhost", 5007);
      }

   }
}