/*
 * SonarQube :: Plugins :: SCM :: SVN
 * Copyright (C) 2014-2017 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.plugins.scm.svn;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.sonar.plugins.scm.svn.SvnPlugin.newSvnClientManager;

public class SvnPluginTest {

  @Test
  public void getExtensions() {
    assertThat(new SvnPlugin().getExtensions().size()).isGreaterThan(1);
  }

  @Test
  public void newSvnClientManager_with_auth() {
    SvnConfiguration config = mock(SvnConfiguration.class);
    when(config.password()).thenReturn("password");
    when(config.passPhrase()).thenReturn("passPhrase");
    assertThat(newSvnClientManager(config)).isNotNull();
  }

  @Test
  public void newSvnClientManager_without_auth() {
    SvnConfiguration config = mock(SvnConfiguration.class);
    assertThat(config.password()).isNull();
    assertThat(config.passPhrase()).isNull();
    assertThat(newSvnClientManager(config)).isNotNull();
  }
}
