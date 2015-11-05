/*!
 * This program is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software
 * Foundation.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 * or from the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * Copyright (c) 2005-2015 Pentaho Corporation..  All rights reserved.
 */

package org.pentaho.reporting.engine.classic.extensions.modules.connections;

import java.util.HashMap;

import javax.sql.DataSource;

import org.pentaho.reporting.libraries.base.boot.SingletonHint;

@SingletonHint
public class StaticDataSourceCacheManager implements DataSourceCacheManager, DataSourceCache {
  private HashMap<String, DataSource> backend;

  public StaticDataSourceCacheManager() {
    backend = new HashMap<String, DataSource>();
  }

  public void put( final String name, final DataSource pool ) {
    backend.put( name, pool );
  }

  public void clear() {
    backend.clear();
  }

  public void remove( final String dsName ) {
    backend.remove( dsName );
  }

  public DataSource get( final String dsName ) {
    return backend.get( dsName );
  }

  public DataSourceCache getDataSourceCache() {
    return this;
  }
}
