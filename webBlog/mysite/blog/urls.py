from django.conf.urls import *
from blog.views import base,imag,SpecificBlog
from django.conf import settings

urlpatterns = patterns('',
    url(r'^$', base),
    url(r'^gallery/$', imag),
    url(r'^(?P<posttitle>.*)/$', SpecificBlog),

)



urlpatterns += patterns('',  
            (r'^static/(?P<path>.*)$', 'django.views.static.serve', {'document_root': settings.STATIC_PATH, 'show_indexes':True}),  
           ) 


urlpatterns += patterns('',  
            (r'^media/(?P<path>.*)$', 'django.views.static.serve',{'document_root': settings. MEDIA_ROOT }),

            ) 
