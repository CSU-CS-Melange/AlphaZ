## AlphaZ 

This repository contains (partial) copy of source code for AlphaZ system 
developed at Colorado State University:
 http://www.cs.colostate.edu/AlphaZ/wiki/

The original repositories are scattered across two sites (CSU, Inria Forge), 
and the connection was not well maintained when projects hosted on Inria 
(shared with GeCoS project) were migrated to gitlab. This port of AlphaZ
includes all plugins that are no longer used by GeCoS and AlphaZ specific. 
All other plugins are fetched from new GeCoS update sites.

Follow the instructions below to install AlphaZ. It should work for Linux and Macosx (64 bits only) including M1 processors.

For examples of how to use AlphaZ, see the original wiki at CSU (linked above).
Also the test project contains many examples:
  https://gitlab.inria.fr/Alpha/alphaz/tree/master/tests/edu.csu.melange.alphaz.mde.tests

### Installation

1. Install Eclipse IDE for Java Developers. In the following version 2021-12 is
assumed: https://www.eclipse.org/downloads/packages/release/2021-12/r
2. Launch eclipse and select a fresh workspace
3. ``Help -> Install new software``
   - Select "2021-12 - http://download.eclipse.org/releases/2021-12" as the repository to work with
   - Search for "Xtext" and select ``Xtext Complete SDK`` and install
   (you may find two or more, but pick one - it shows up under multiple categories, but they are the same thing)
4. ``Help -> Install new software -> Manage...``
   - Click on ``Add...`` to add a new repository. Create entries for the following 7 locations:
       * Name: ``gecos framework``  
         Location: ``https://gecos.gitlabpages.inria.fr/gecos-framework/artifacts/``
       * Name: ``gecos emf tools``  
         Location: ``https://gecos.gitlabpages.inria.fr/gecos-tools/gecos-tools-emf/artifacts/``
       * Name: ``gecos graph tools``  
         Location: ``https://gecos.gitlabpages.inria.fr/gecos-tools/gecos-tools-graph/artifacts/``
       * Name: ``gecos isl``  
         Location: ``https://gecos.gitlabpages.inria.fr/gecos-tools/gecos-tools-isl/artifacts/``
       * Name: ``gecos jni mapper``  
         Location: ``https://gecos.gitlabpages.inria.fr/gecos-tools/gecos-tools-jnimapper/artifacts/``
       * Name: ``gecos tom mapping``  
         Location: ``https://gecos.gitlabpages.inria.fr/gecos-tools/gecos-tools-tommapping/artifacts/``
       * Name: ``gecos tom sdk``  
         Location: ``https://gecos.gitlabpages.inria.fr/gecos-tools/gecos-tools-tomsdk/artifacts/``
   - Click on ``Apply and Close``
   - Set "Work with:" to ``--All Available Sites--`` and filter on the string ``gecos`` to populate the list with artifacts from the repositories that were just added
   - Select the following:
       * EMF Tools
       * Framework
       * Graph Tools
       * ISL
       * JNI Mapper
       * Tom Mapping
       * Tom SDK
       * Uncategorized (expanding this should show the "JNI Barvinok bindings")
   - Install all of the above 
5. ``Help -> Install new software``
   - Click on ``Add...`` to add a new repository: ``https://cs.colostate.edu/AlphaZ/update-sites/2022-08.2/``
   - Make sure "Work with:" points to the added repository 
   - Select ``AlphaZ`` and install

### Instructions for Installing from Source Code

Do the steps above and then additionally do the following:

1. Checkout AlphaZ projects from git repository (here)
2. Open ``Preferences -> Java -> Compiler`` and set ``Compiler compliance level`` to 1.8
3. Select ``Import projects -> General -> Existing Projects into Workspace``
    - Select root directory to be where the git repository was checked out
    - Import all projects
   
