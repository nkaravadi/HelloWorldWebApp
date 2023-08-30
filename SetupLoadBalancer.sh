kubectl apply -f metallb/metallb-native.yaml
kubectl wait --namespace metallb-system --for=condition=ready pod --selector=app=metallb --timeout=90s

kubectl apply -f metallb/metallb-conf.yaml 