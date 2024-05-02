#!/bin/bash
kubectl delete -f pvc.yml 
kubectl delete -f sql-deploy.yml
kubectl delete -f wordpress-deploy.yml
kubectl delete -f expose.yml