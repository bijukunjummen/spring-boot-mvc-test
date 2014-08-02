read -r -d '' VCAP_APPLICATION <<'ENDOFVAR'
{"limits":{"mem":1024,"disk":1024,"fds":16384},"application_version":"2360661b-1448-4743-9d64-868d0fee4967","application_name":"rapwiki-blue","application_uris":["rapwiki-blue.apps.pivotalservices.org","rapwiki.apps.pivotalservices.org"],"version":"2360661b-1448-4743-9d64-868d0fee4967","name":"rapwiki-blue","space_name":"development","space_id":"66d6e4e7-6ae7-4421-b398-66acf6f4e068","uris":["rapwiki-blue.apps.pivotalservices.org","rapwiki.apps.pivotalservices.org"],"users":null,"instance_id":"b331b6f53e1a4378adf2206fa840a5af","instance_index":0,"host":"0.0.0.0","port":61008,"started_at":"2014-07-15 15:38:26 +0000","started_at_timestamp":1405438706,"start":"2014-07-15 15:38:26 +0000"} 
ENDOFVAR

export VCAP_APPLICATION=$VCAP_APPLICATION

read -r -d '' VCAP_SERVICES <<'ENDOFVAR'
{"postgres":[{"name":"psgservice","label":"postgresql","tags":["postgresql"],"plan":"Standard","credentials":{"uri":"postgres://postgres:p0stgr3s@bkunjummen-mbp.local:5432/hotelsdb"}}]}
ENDOFVAR

export VCAP_SERVICES=$VCAP_SERVICES

mvn spring-boot:run
