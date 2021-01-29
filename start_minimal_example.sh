#!/bin/bash

cd minimal
cd server/org.eclipse.glsp.example.minimal && mvn clean install && cd ../..
cd client && yarn

yarn start:browser
