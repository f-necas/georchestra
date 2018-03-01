# geOrchestra

[![Build Status](https://travis-ci.org/georchestra/georchestra.svg?branch=17.12)](https://travis-ci.org/georchestra/georchestra)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/a879ac64588d4357ab72e79cd8026f99)](https://www.codacy.com/app/georchestra/georchestra)

geOrchestra is a complete **Spatial Data Infrastructure** solution.

It features a **metadata catalog** (GeoNetwork 3.0.4), an **OGC server** (GeoServer 2.8.3 and GeoWebCache 1.8.1) with fine-grained access control (based on GeoFence), an **advanced viewer and editor**, an **extractor** and **many more** (security and auth system based on proxy/CAS/LDAP, analytics, admin UIs, ...)


## Releases

A new release is published every 6 months and is supported during 12 months.
Stable versions are named by their release date, eg 17.12 (latest stable) was supposed to be be published in december 2017 (but the truth is, it was released february 2018).

Have a look at the [release notes](RELEASE_NOTES.md) for more information.


## Install

Depending on your goals and skills, there are several ways to install geOrchestra:

 * a [docker composition](https://github.com/georchestra/docker/blob/master/docker-compose.yml), which pulls pre-built images from [docker hub](https://hub.docker.com/u/georchestra/), is perfect for a quick start. Provided you have a good download speed and recent machine (8Gb required), you'll be up and running within 10 minutes. Read [how to run geOrchestra on Docker](https://github.com/georchestra/docker/blob/master/README.md) here.
 * a contributed [ansible playbook](https://github.com/georchestra/ansible) allows you to spin an instance in a few minutes. This is probably the easiest way to create a small production server, since it takes care of installing the middleware, fetching the webapps and configuring them.
 * generic [debian (or yum) packages](https://packages.georchestra.org/) are perfect to create complex architectures, but you'll have to [install and configure the middleware](docs/setup.md) first.
 * you could also use the [generic wars](https://packages.georchestra.org/wars-master/) with their "[datadir](https://github.com/georchestra/datadir)", as an alternate method. The above packages provide both.
 * finally, [building from the sources](docs/build.md) is the most flexible solution, since it allows you to customize the webapps very deeply. You get custom WAR files, packages or docker images that you can [deploy](docs/deploy.md) to dev, test, or production servers.

If you opt for the middleware setup by yourself, there are several [optimizations](docs/optimizations.md), [good practices](docs/good_practices.md) and [tutorials](docs/tutorials.md) that are worth reading.
Note that the minimum system requirement is 2 cores and 4Gb RAM, but we recommend at least 4 cores and 8 Gb RAM for a production instance.
More RAM is of course better !


## Community

If you need more information, please ask on the [geOrchestra mailing list](https://groups.google.com/forum/#!forum/georchestra).

For help setting up your instance, or for dev-related questions, use the [#georchestra](https://kiwiirc.com/client/irc.freenode.net/georchestra) IRC channel or the [dev/tech list](https://groups.google.com/forum/#!forum/georchestra-dev).


## More

Additional information can be found in the [georchestra.org](http://www.georchestra.org/) website and in the following links:
 * [catalog](https://github.com/georchestra/geonetwork/blob/georchestra-gn3-15.12/README.md): standard GeoNetwork with a light customization,
 * [viewer](mapfishapp/README.md) (aka mapfishapp): a robust, OGC-compliant webgis with editing capabilities,
 * [extractor](extractorapp/README.md) (aka extractorapp): able to create zips from data served through OGC web services and send an email when your extraction is done,
 * [geoserver](http://geoserver.org/): the reference implementation for many OGC web services,
 * [geowebcache](http://geowebcache.org/): a fast and easy to use tile cache,
 * [geofence](https://github.com/georchestra/geofence/blob/georchestra/georchestra.md): optional, advanced OGC web services security,
 * [analytics](analytics/README.md): admin-oriented module, a front-end to the [ogc-server-statistics](ogc-server-statistics/README.md) module,
 * [console](console/README.md): also an admin-oriented module, to manage users and groups,
 * [header](header/README.md): the common header which is used by all modules,
 * [epsg-extension](epsg-extension/README.md): a plugin to override the geotools srs definitions.
 * [atlas](atlas/README.md): a server-side component to print multi-page PDF with one geographic feature per page.
