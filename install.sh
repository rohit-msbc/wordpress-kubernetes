#!/bin/bash
# grafana pod
helm repo add grafana https://grafana.github.io/helm-charts
helm install my-grafana grafana/grafana --version 7.3.9
# prometheus pod
helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm install my-prometheus prometheus-community/prometheus --version 25.20.1
# jenkins pod
helm repo add jenkinsci https://charts.jenkins.io/
helm install my-jenkins jenkinsci/jenkins --version 5.1.8
