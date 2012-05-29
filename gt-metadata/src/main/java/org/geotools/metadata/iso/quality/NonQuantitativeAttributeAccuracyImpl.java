/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 * 
 *    (C) 2007-2008, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 *
 *    This package contains documentation from OpenGIS specifications.
 *    OpenGIS consortium's work is fully acknowledged here.
 */
package org.geotools.metadata.iso.quality;

import org.opengis.metadata.quality.NonQuantitativeAttributeAccuracy;


/**
 * Accuracy of non-quantitative attributes.
 *
 *
 * @source $URL: http://svn.osgeo.org/geotools/tags/2.7.4/modules/library/metadata/src/main/java/org/geotools/metadata/iso/quality/NonQuantitativeAttributeAccuracyImpl.java $
 * @version $Id: NonQuantitativeAttributeAccuracyImpl.java 37298 2011-05-25 05:16:15Z mbedward $
 * @author Cory Horner (Refractions Research)
 *
 * @since 2.4
 */
public class NonQuantitativeAttributeAccuracyImpl extends ThematicAccuracyImpl
        implements NonQuantitativeAttributeAccuracy
{
    /**
     * Serial number for interoperability with different versions.
     */
    private static final long serialVersionUID = 2659617465862554345L;

    /**
     * Constructs an initially empty non quantitative attribute correctness.
     */
    public NonQuantitativeAttributeAccuracyImpl() {
    }

    /**
     * Constructs a metadata entity initialized with the values from the specified metadata.
     *
     * @since 2.4
     */
    public NonQuantitativeAttributeAccuracyImpl(final NonQuantitativeAttributeAccuracy source) {
        super(source);
    }
}
