#!/bin/bash
kubectl apply -f pvc.yml 
kubectl apply -f sql-deploy.yml
kubectl apply -f wordpress-deploy.yml
kubectl apply -f expose.yml

